package sdetEssentials.Deserialization;

import java.util.List;

public class RootPojo {
    private List<DesktopPojo> desktopPojoList;

    @Override
    public String toString() {
        return "RootPojo{" +
                "desktopPojoList=" + desktopPojoList +
                ", mobilePojoList=" + mobilePojoList +
                '}';
    }

    public List<DesktopPojo> getDesktopPojoList() {
        return desktopPojoList;
    }

    public void setDesktopPojoList(List<DesktopPojo> desktopPojoList) {
        this.desktopPojoList = desktopPojoList;
    }

    public List<MobilePojo> getMobilePojoList() {
        return mobilePojoList;
    }

    public void setMobilePojoList(List<MobilePojo> mobilePojoList) {
        this.mobilePojoList = mobilePojoList;
    }

    private List<MobilePojo>mobilePojoList;
}
