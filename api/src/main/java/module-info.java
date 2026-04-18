/**
 * @author VISTALL
 * @since 06/02/2023
 */
module consulo.vaadin.api
{
	requires transitive com.intellij.gwt.api;
	requires transitive com.intellij.gwt.base;
	requires transitive consulo.java.language.api;

	requires consulo.application.content.api;
	requires consulo.compiler.api;
	requires consulo.disposer.api;
	requires consulo.language.api;
	requires consulo.localize.api;
	requires consulo.module.api;
	requires consulo.module.content.api;
	requires consulo.module.ui.api;
	requires consulo.ui.api;
	requires consulo.ui.ex.awt.api;
	requires consulo.util.lang;
	requires consulo.virtual.file.system.api;

	exports consulo.vaadin.bundle;
	exports consulo.vaadin.icon;
	exports consulo.vaadin.module.extension;

	// TODO remove in future
	requires java.desktop;
}
