package sdetEssentials.Deserialization;

public class DevicePojo {
    public String getDevice() {
        return device;
    }

    @Override
    public String toString() {
        return "DevicePojo{" +
                "device='" + device + '\'' +
                ", display_name='" + display_name + '\'' +
                ", os_version='" + os_version + '\'' +
                ", real_mobile='" + real_mobile + '\'' +
                '}';
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getReal_mobile() {
        return real_mobile;
    }

    public void setReal_mobile(String real_mobile) {
        this.real_mobile = real_mobile;
    }

    private String device;
    private String display_name;
    private String os_version;
    private String real_mobile;
}
