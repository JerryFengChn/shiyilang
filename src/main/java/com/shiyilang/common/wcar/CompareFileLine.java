package com.shiyilang.common.wcar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompareFileLine {
    public static void main(String[] args) {

        String originalFileName = "D:/ori.txt";
        String inputFileName = "D:/inp.txt";
        String outputFileName = "D:/contains.txt";
        readFileByLinesOutputDifference(originalFileName,inputFileName,outputFileName);


        //String originalFileName = "D:/NISSAN/pads data/pads_probe.txt";
        //String inputFileName = "D:/NISSAN/pads data/pads_notification.txt";
        //String outputFileName = "D:/NISSAN/pads data/probe_notification.txt";
        //readFileByLinesOutputCombineLines(originalFileName,inputFileName,outputFileName);
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件,输出一行中有第一不同第二相同的行
     */
    public static void readFileByLinesOutputCNotSameLine(String originalFileName, String inputFileName,String outputFileName) {
        File originalFile = new File(originalFileName);
        BufferedReader originalReader = null;
        File compareFile = new File(inputFileName);
        long compareSize = compareFile.length();
        System.out.println("compareSize = " + compareSize);
        BufferedReader compareReader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：并放入List用来比较");
            originalReader = new BufferedReader(new FileReader(originalFile));
            List<String> originalList = new ArrayList<String>();
            String originalTempString = null;
            int originalLine = 1;
            compareReader = new BufferedReader(new FileReader(compareFile));
            compareReader.mark((int) compareSize+1);
            StringBuffer writeStr = new StringBuffer();
            // 一次读入一行，直到读入null为文件结束
            while ((originalTempString = originalReader.readLine()) != null) {
                // 显示行号
                System.out.println("originalLine " + originalLine + ": " + originalTempString);
                writeStr = compareLineBySeparate(originalTempString, compareReader, writeStr);
                //writeStr = writeStr.append(tempString).append(System.lineSeparator());
                originalLine++;
            }
            originalReader.close();
            writeByBufferedReader(writeStr.toString(),outputFileName,true);
            compareReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (compareReader != null) {
                try {
                    compareReader.close();
                } catch (IOException e1) {
                }
            }
            if (originalReader != null) {
                try {
                    originalReader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件,输出兩個文件不同的行
     */
    public static void readFileByLinesOutputDifference(String originalFileName, String inputFileName,String outputFileName) {
        File originalFile = new File(originalFileName);
        BufferedReader originalReader = null;
        File file = new File(inputFileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：并放入List用来比较");
            originalReader = new BufferedReader(new FileReader(originalFile));
            List<String> originalList = new ArrayList<String>();
            String originalTempString = null;
            int originalLine = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((originalTempString = originalReader.readLine()) != null) {
                // 显示行号
                System.out.println("originalLine " + originalLine + ": " + originalTempString);
                //String[] originalTempArray = originalTempString.split(",");
                originalList.add(originalTempString);
                originalLine++;
            }
            originalReader.close();
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            reader.mark((int)file.length()+1);
            StringBuffer writeStr = new StringBuffer();
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            for (String s : originalList) {
                String[] originaArray = s.split(",");
                while ((tempString = reader.readLine()) != null) {
                    // 显示行号
                    //System.out.println("line " + line + ": " + tempString);
                    String[] tempArray = tempString.split(",");
                    if (!originaArray[0].equals(tempArray[0]) && originaArray[1].equals(tempArray[1])) {
                        writeStr = writeStr.append(tempString).append(System.lineSeparator());
                    }
                    line++;
                }
                reader.reset();
            }

            writeByBufferedReader(writeStr.toString(),outputFileName,true);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            if (originalReader != null) {
                try {
                    originalReader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件,输出两个文件的并集
     */
    public static void readFileByLinesOutputCombineLines(String originalFileName, String inputFileName,String outputFileName) {
        File originalFile = new File(originalFileName);
        BufferedReader originalReader = null;
        File file = new File(inputFileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：并放入List用来比较");
            originalReader = new BufferedReader(new FileReader(originalFile));
            List<String> originalList = new ArrayList<String>();
            String originalTempString = null;
            int originalLine = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((originalTempString = originalReader.readLine()) != null) {
                // 显示行号
                System.out.println("originalLine " + originalLine + ": " + originalTempString);
                originalList.add(originalTempString);
                originalLine++;
            }
            originalReader.close();
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            StringBuffer writeStr = new StringBuffer();
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                if (!originalList.contains(tempString)) {
                    writeStr = writeStr.append(tempString).append(System.lineSeparator());
                }

                line++;
            }
            writeByBufferedReader(writeStr.toString(),outputFileName,true);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            if (originalReader != null) {
                try {
                    originalReader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件,输出两个文件的交集
     */
    public static void readFileByLinesAndOutputInterLines(String originalFileName, String inputFileName,String outputFileName) {
        File originalFile = new File(originalFileName);
        BufferedReader originalReader = null;
        File file = new File(inputFileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：并放入List用来比较");
            originalReader = new BufferedReader(new FileReader(originalFile));
            List<String> originalList = new ArrayList<String>();
            String originalTempString = null;
            int originalLine = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((originalTempString = originalReader.readLine()) != null) {
                // 显示行号
                System.out.println("originalLine " + originalLine + ": " + originalTempString);
                originalList.add(originalTempString);
                originalLine++;
            }
            originalReader.close();
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            StringBuffer writeStr = new StringBuffer();
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                if (originalList.contains(tempString)) {
                    writeStr = writeStr.append(tempString).append(System.lineSeparator());
                }

                line++;
            }
            writeByBufferedReader(writeStr.toString(),outputFileName,false);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            if (originalReader != null) {
                try {
                    originalReader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    public static void writeByBufferedReader(String content,String outputFileName,boolean appender) {
        try {

            File file = new File(outputFileName);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, appender);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static StringBuffer compareLineBySeparate(String compareString, BufferedReader compareReader, StringBuffer writeStr) {
        String tempString = null;
        int line = 1;
        String[] arrayOriginal = compareString.split(",");
        try {
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = compareReader.readLine()) != null) {
                String[] arrayCompare = tempString.split(",");
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                if (!arrayOriginal[0].equals(arrayCompare[0]) && arrayOriginal[1].equals(arrayCompare[1])) {
                    writeStr = writeStr.append(tempString).append(System.lineSeparator());
                }
                line++;
                System.out.println("have compare string" + writeStr.toString());
            }
            compareReader.reset();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return writeStr;
    }
}
