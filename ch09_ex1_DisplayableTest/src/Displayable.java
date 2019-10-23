public interface Displayable {
    //String getDisplayText();
		
    default String getDisplayText() {
        return toString();
    }
}
