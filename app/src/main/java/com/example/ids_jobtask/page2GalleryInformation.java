package com.example.ids_jobtask;

public class page2GalleryInformation {
    String Caption;
    String CroppedImage320x308;

    public page2GalleryInformation(String caption, String croppedImage320x308) {
        Caption = caption;
        CroppedImage320x308 = croppedImage320x308;
    }

    public page2GalleryInformation() {
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    public String getCroppedImage320x308() {
        return CroppedImage320x308;
    }

    public void setCroppedImage320x308(String croppedImage320x308) {
        CroppedImage320x308 = croppedImage320x308;
    }
}
