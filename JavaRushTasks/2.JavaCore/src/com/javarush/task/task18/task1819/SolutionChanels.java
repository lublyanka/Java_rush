package com.javarush.task.task18.task1819;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* 
Объединение файлов
*/

public class SolutionChanels {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        try (FileInputStream inputStream1 = new FileInputStream(filename1);
             FileInputStream inputStream2 = new FileInputStream(filename2);
             FileChannel input1 = inputStream1.getChannel();
             FileChannel input2 = inputStream2.getChannel();
             RandomAccessFile outputFile = new RandomAccessFile(filename1, "rw");
             FileChannel output = outputFile.getChannel();
             ) {

            long input1Size = input1.size();
            long input2Size = input2.size();
            outputFile.setLength(input2Size+input1Size);

            if (input2Size >= input1Size) {
                long lastPosition = input2Size;
                long totalTransferred = 0L;
                long transferred;
                while ((transferred = output.transferFrom(input1, lastPosition, input1Size - totalTransferred)) > 0) {
                    lastPosition += transferred;
                    totalTransferred += transferred;
                }

                lastPosition = 0L;
                totalTransferred = 0L;
                while ((transferred = output.transferFrom(input2, lastPosition, input2Size - totalTransferred)) > 0) {
                    lastPosition += transferred;
                    totalTransferred += transferred;
                }
            } else {
                long toCopy = input1Size - input2Size;

                output.position(input2Size);
                long lastPosition = input2Size*2;
                long totalTransferred = 0L;
                long transferred;
                while ((transferred = output.transferFrom(output, lastPosition, toCopy - totalTransferred)) > 0) {
                    lastPosition += transferred;
                    totalTransferred += transferred;
                }

                output.position(0);
                lastPosition = input2Size;
                totalTransferred = 0L;
                while ((transferred = output.transferFrom(output, lastPosition, input2Size - totalTransferred)) > 0) {
                    lastPosition += transferred;
                    totalTransferred += transferred;
                }

                lastPosition = 0L;
                totalTransferred = 0L;
                while ((transferred = output.transferFrom(input2, lastPosition, input2Size - totalTransferred)) > 0) {
                    lastPosition += transferred;
                    totalTransferred += transferred;
                }
            }

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
