/**
 * @author VISTALL
 * @since 06/02/2023
 */
module consulo.vaadin.api
{
	requires transitive com.intellij.gwt.api;
	requires transitive com.intellij.gwt.base;
	requires transitive consulo.java.language.api;

	exports consulo.vaadin.bundle;
	exports consulo.vaadin.icon;
	exports consulo.vaadin.module.extension;

	// TODO remove in future
	requires java.desktop;
}