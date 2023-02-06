package consulo.vaadin.module.extension;

import consulo.annotation.component.ExtensionImpl;
import consulo.localize.LocalizeValue;
import consulo.module.content.layer.ModuleExtensionProvider;
import consulo.module.content.layer.ModuleRootLayer;
import consulo.module.extension.ModuleExtension;
import consulo.module.extension.MutableModuleExtension;
import consulo.ui.image.Image;
import consulo.vaadin.icon.VaadinIconGroup;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author VISTALL
 * @since 06/02/2023
 */
@ExtensionImpl
public class JavaEEVaadinModuleExtensionProvider implements ModuleExtensionProvider<JavaEEVaadinModuleExtension>
{
	@Nonnull
	@Override
	public String getId()
	{
		return "javaee-vaadin";
	}

	@Nullable
	@Override
	public String getParentId()
	{
		return "java";
	}

	@Nonnull
	@Override
	public LocalizeValue getName()
	{
		return LocalizeValue.localizeTODO("Vaadin");
	}

	@Nonnull
	@Override
	public Image getIcon()
	{
		return VaadinIconGroup.vaadin();
	}

	@Nonnull
	@Override
	public ModuleExtension<JavaEEVaadinModuleExtension> createImmutableExtension(@Nonnull ModuleRootLayer moduleRootLayer)
	{
		return new JavaEEVaadinModuleExtension(getId(), moduleRootLayer);
	}

	@Nonnull
	@Override
	public MutableModuleExtension<JavaEEVaadinModuleExtension> createMutableExtension(@Nonnull ModuleRootLayer moduleRootLayer)
	{
		return new JavaEEVaadinMutableModuleExtension(getId(), moduleRootLayer);
	}
}
