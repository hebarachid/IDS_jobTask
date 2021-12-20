public class page1GalleryInformation {

    String  Name;
    String CroppedImage320x308;

    public page1GalleryInformation(String name, String croppedImage320x308) {
        Name = name;
        CroppedImage320x308 = croppedImage320x308;
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
