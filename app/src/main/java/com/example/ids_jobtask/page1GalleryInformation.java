package com.example.ids_jobtask;

public class page1GalleryInformation {

    String  Name;
    String CroppedImage320x308;
    String ID;
    public page1GalleryInformation() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public page1GalleryInformation(String name, String croppedImage320x308, String id) {
        Name = name;
        CroppedImage320x308 = croppedImage320x308;
        ID=id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCroppedImage320x308() {
        return CroppedImage320x308;
    }

    public void setCroppedImage320x308(String croppedImage320x308) {
        CroppedImage320x308 = croppedImage320x308;
    }
}
