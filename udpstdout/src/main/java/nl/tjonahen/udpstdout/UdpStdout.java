package nl.tjonahen.udpstdout;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpStdout {

    public static void main(String args[]) throws Exception {
        System.out.println("Starting UDP to stdout on port 11514");
        DatagramSocket serverSocket = new DatagramSocket(11514);
        byte[] receiveData = new byte[1024+1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println(sentence);
        }
    }
}
