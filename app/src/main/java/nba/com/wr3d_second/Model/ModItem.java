package nba.com.wr3d_second.Model;

public class ModItem {
    private String Name;
    private String ImageUrl;

    public ModItem() {
    }

    public ModItem(String name, String imageUrl) {
        Name = name;
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
