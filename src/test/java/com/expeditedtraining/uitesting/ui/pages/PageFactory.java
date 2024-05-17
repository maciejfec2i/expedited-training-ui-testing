package com.expeditedtraining.uitesting.ui.pages;

import com.expeditedtraining.uitesting.utils.ClassReader;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.text.WordUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The purpose of this class is to deliver an instance of the {@link PageObject} class from the provided class name
 * as a {@link String} from a specified {@link Package} package instance.
 *
 * @author Maciej Fec
 * @version 10/05/2024
 */
public class PageFactory {

    private final Package aPackage;

    public PageFactory(Package aPackage) {
        this.aPackage = aPackage;
    }

    public static PageFactory from(Package aPackage) {
        return new PageFactory(aPackage);
    }

    /**
     * Used for retrieving a {@link PageObject} instance of the provided page name.
     *
     * @param pageName A {@link String} instance of the required page name.<br><br> This should ideally be passed in as standard
     *                 text with whitespaces i.e. LoginPage -> Login Page or login page. Any uppercase acronyms that
     *                 may be present in the page name, should already be passed in as uppercase.
     * @return A {@link PageObject} instance of the provided page name.
     *
     * @author Maciej Fec
     * @version 10/05/2024
     */
    public PageObject getPageCalled(String pageName) {
        Map<String, String> discoveredPages = ClassReader.getClassMapFrom(aPackage);

        if(pageName.contains(" ")) {
            pageName = Stream.of(pageName.split(" "))
                    .map(nameChunk -> {
                        if(nameChunk.equals(nameChunk.toUpperCase())) return nameChunk;
                        return WordUtils.capitalize(nameChunk);
                    })
                    .collect(Collectors.joining("")) + "Page";
        }

        // Covers instances where the page name is a single word
        if(!pageName.toLowerCase().contains("page")) pageName += "Page";

        if(!discoveredPages.containsKey(pageName)) {
            throw new RuntimeException(
                    String.format(
                            "Page %s could not be found in the %s package or any of its subpackages",
                            pageName,
                            aPackage.getName())
            );
        }

        try {
            return (PageObject) Class.forName(discoveredPages.get(pageName)).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
