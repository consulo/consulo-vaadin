/*
 * Copyright 2013-2016 must-be.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package consulo.vaadin.module.extension;

import com.intellij.gwt.module.model.GwtModule;
import consulo.compiler.FileProcessingCompiler;
import consulo.content.bundle.SdkType;
import consulo.gwt.base.module.extension.impl.GoogleGwtModuleExtensionImpl;
import consulo.language.content.LanguageContentFolderScopes;
import consulo.module.content.layer.ContentFolder;
import consulo.module.content.layer.ModuleRootLayer;
import consulo.vaadin.bundle.VaadinBundleType;
import consulo.virtualFileSystem.VirtualFile;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VISTALL
 * @since 25-May-16
 */
public class JavaEEVaadinModuleExtension extends GoogleGwtModuleExtensionImpl<JavaEEVaadinModuleExtension>
{
	protected final Map<String, String> myPackagingPaths = new HashMap<String, String>();

	public JavaEEVaadinModuleExtension(@Nonnull String id, @Nonnull ModuleRootLayer rootModel)
	{
		super(id, rootModel);
		myCompilerMaxHeapSize = 1024;
	}

	@Override
	public void addFilesForCompilation(GwtModule gwtModule, List<FileProcessingCompiler.ProcessingItem> result)
	{
		ContentFolder[] contentFolders = getModuleRootLayer().getContentFolders(LanguageContentFolderScopes.productionAndTest());
		for(ContentFolder contentFolder : contentFolders)
		{
			VirtualFile file = contentFolder.getFile();
			if(file == null)
			{
				continue;
			}

			addFilesRecursively(gwtModule, this, file, result);
		}
	}

	@Nonnull
	@Override
	public Class<? extends SdkType> getSdkTypeClass()
	{
		return VaadinBundleType.class;
	}

	@Override
	@Nonnull
	public String getPackagingRelativePath(@Nonnull GwtModule module)
	{
		String moduleName = module.getQualifiedName();
		String path = myPackagingPaths.get(moduleName);
		if(path != null)
		{
			return path;
		}
		return "/" + moduleName;
	}
}
