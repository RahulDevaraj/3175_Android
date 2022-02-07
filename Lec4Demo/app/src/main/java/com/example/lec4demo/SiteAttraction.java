package com.example.lec4demo;

public class SiteAttraction {

    String SiteName;
    int SitePic;

    public SiteAttraction(String siteName, int sitePic) {
        SiteName = siteName;
        SitePic = sitePic;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public int getSitePic() {
        return SitePic;
    }

    public void setSitePic(int sitePic) {
        SitePic = sitePic;
    }
}
