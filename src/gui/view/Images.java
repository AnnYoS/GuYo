package gui.view;

public class Images {

    private String darkimage;
    private String lightimage;

    public Images(String pathdark, String pathlight){
        darkimage = pathdark;
        lightimage = pathlight;
    }

    /**
     * @return the image for dark theme
     */
    public String getDarkimage() {
        return darkimage;
    }

    /**
     * @return the image for light theme
     */
    public String getLightimage() {
        return lightimage;
    }
}
