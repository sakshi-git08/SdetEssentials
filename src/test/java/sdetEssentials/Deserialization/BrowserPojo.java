package sdetEssentials.Deserialization;

public class BrowserPojo {
    private String browser;

    public String getBrowser() {
        return browser;
    }

    @Override
    public String toString() {
        return "BrowserPojo{" +
                "browser='" + browser + '\'' +
                ", browser_version='" + browser_version + '\'' +
                ", display_name='" + display_name + '\'' +
                '}';
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowser_version() {
        return browser_version;
    }

    public void setBrowser_version(String browser_version) {
        this.browser_version = browser_version;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    private String browser_version;
    private String display_name;
}
