package util;

import java.io.InputStream;

public class ResourceLoaders {
    public ClassLoader classLoader = getClass().getClassLoader();

    /**
     * Loads a given resource using the relative path. Returns an InputStream.
     * @param relativePath - the relative path, uses forward slash.
     * @return {@code InputStream} based on the relative path given
     */
    public InputStream loadResource(String relativePath) {
        return classLoader.getResourceAsStream(relativePath);
    }
}
