package sdetEssentials.Deserialization;

import java.util.List;

public class DesktopPojo {
    private String os;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "DesktopPojo{" +
                "os='" + os + '\'' +
                ", os_version='" + os_version + '\'' +
                ", os_display_name='" + os_display_name + '\'' +
                ", browserPojoList=" + browserPojoList +
                '}';
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getOs_display_name() {
        return os_display_name;
    }

    public void setOs_display_name(String os_display_name) {
        this.os_display_name = os_display_name;
    }

    public List<BrowserPojo> getBrowserPojoList() {
        return browserPojoList;
    }

    public void setBrowserPojoList(List<BrowserPojo> browserPojoList) {
        this.browserPojoList = browserPojoList;
    }

    private String os_version;
    private String os_display_name;
    private List<BrowserPojo> browserPojoList;
}
