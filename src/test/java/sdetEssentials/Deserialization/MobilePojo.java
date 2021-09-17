package sdetEssentials.Deserialization;

import java.util.List;

public class MobilePojo {
    private String os;

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "MobilePojo{" +
                "os='" + os + '\'' +
                ", os_display_name='" + os_display_name + '\'' +
                ", devicePojoList=" + devicePojoList +
                '}';
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs_display_name() {
        return os_display_name;
    }

    public void setOs_display_name(String os_display_name) {
        this.os_display_name = os_display_name;
    }

    public List<DevicePojo> getDevicePojoList() {
        return devicePojoList;
    }

    public void setDevicePojoList(List<DevicePojo> devicePojoList) {
        this.devicePojoList = devicePojoList;
    }

    private String os_display_name;
    private List<DevicePojo> devicePojoList;
}
