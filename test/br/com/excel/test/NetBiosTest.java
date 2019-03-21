/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author tiago.teixeira
 */
public class NetBiosTest {

    //Classe A || /8 = [10.0.0.0] - [0x0A.0x00.0x00.0x00]
    //Classe B || /16 = 172.16.0.0 - [0xAC.]
    //Classe C || /24 = 192.168.0.0 - []
    Integer[] mask = new Integer[]{255, 255, 255, 0};

    public static void main(String[] args) {
        NetBiosTest nbt = new NetBiosTest();
        nbt.getNetworkClass();
    }

    public String netbiosTest(String name) {
        try {

            InetAddress inetAddress = InetAddress.getByName(name);
            String ip = "";
            if (inetAddress != null && inetAddress.isReachable(100)) {
                ip = inetAddress.getHostAddress();
                boolean deviceFound = true;
                //selfFound = selfIp.equals(ip);

                //if (!selfFound) {
                //    NbtAddress[] addressList = NbtAddress.getAllByAddress(address);
                //    NbtAddress nbtAddress = addressList[0];
                //    if (address != null) {
                //        deviceName = nbtAddress.getHostName();
                //    }
                //}
            }
            return ip;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void networkScan() {
        try {
            Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
            while (ni.hasMoreElements()) {
                NetworkInterface network = ni.nextElement();
                network.getInterfaceAddresses().forEach(iaa -> {
                    System.out.println(iaa.getNetworkPrefixLength());
                });
                Enumeration<InetAddress> andresses = network.getInetAddresses();
                while (andresses.hasMoreElements()) {
                    InetAddress ia = andresses.nextElement();
                    System.out.println(ia.getHostAddress());
                    System.out.println(ia.getHostName());
                    for (byte b : ia.getAddress()) {
                        System.out.print((char) b);
                    }
                    System.out.println("\n");
                }
            }
        } catch (Exception e) {
        }
    }

    public String getLocalAddress() {
        Enumeration<NetworkInterface> nets;
        try {
            nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets)) {
                Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().matches("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")) {
                        //System.out.println("IP Address:" + inetAddress.getHostAddress());
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    public void getNetworkClass() {
        try {
            System.out.println(getLocalAddress());
        } catch (Exception e) {
        }
    }

}
