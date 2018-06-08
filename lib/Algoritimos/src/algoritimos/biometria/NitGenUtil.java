/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.biometria;

import com.nitgen.SDK.BSP.NBioBSPJNI;
import com.nitgen.SDK.BSP.NBioBSPJNI.DEVICE_ENUM_INFO;

/**
 *
 * @author tiago.teixeira
 */
public class NitGenUtil {
    
    private static NBioBSPJNI bsp;
    private static NBioBSPJNI.DEVICE_ENUM_INFO deviceEnumInfo;
    private static NBioBSPJNI.FIR_HANDLE firhandle;
    
    public static void verificaBiometria() {
        bsp = new NBioBSPJNI();

        deviceEnumInfo = bsp.new DEVICE_ENUM_INFO();

        bsp.EnumerateDevice(deviceEnumInfo);

        // Device Open
        bsp.OpenDevice(deviceEnumInfo.DeviceInfo[0].NameID,
                deviceEnumInfo.DeviceInfo[0].Instance);
        
        bsp.Capture(firhandle);
        // Device Close
        bsp.CloseDevice(deviceEnumInfo.DeviceInfo[0].NameID,
                deviceEnumInfo.DeviceInfo[0].Instance);
    }

    private static Boolean WriteFile(String fileName, byte[] data) {
        java.io.File newFile = new java.io.File(fileName);
        java.io.DataOutputStream out;

        try {
            out = new java.io.DataOutputStream(new java.io.FileOutputStream(newFile, false));
        } catch (java.io.FileNotFoundException ex) {
            //labelStatus.setText("File Creat failed!!");
            return false;
        }

        try {
            out.write(data);
            out.close();
        } catch (java.io.IOException e) {
            //labelStatus.setText("File Write failed!!");
            return false;
        }

        return true;
    }

    public static Boolean CheckError() {
        if (bsp.IsErrorOccured()) {
            //labelStatus.setText("NBioBSP Error Occured [" + bsp.GetErrorCode() + "]");
            return true;
        }

        return false;
    }
    
}
