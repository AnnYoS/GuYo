package gui.view;

public class GuIconPair {

    private GuIcon darkIcon;
    private GuIcon lightIcon;

    /**
     * create new Icons who need to change color
     * @param path path of images (without black or white)
     * @param extension images extension (ex: .png)
     */
    public GuIconPair(String path, String extension){
        darkIcon = new GuIcon((path+"black"), extension);
        lightIcon = new GuIcon((path+"white"), extension);
    }

    /**
     * create new Icons who need to change color by copy
     */
    public GuIconPair(GuIcon icondark, GuIcon iconlight){
        darkIcon = new GuIcon(icondark.getPath());
        lightIcon = new GuIcon(iconlight.getPath());
    }

    /**
     * @return black icon for button
     */
    public GuIcon getDarkIcon() {
        return darkIcon;
    }

    /**
     * @return white icon for button
     */
    public GuIcon getLightIcon() {
        return lightIcon;
    }
}
