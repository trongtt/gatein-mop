/**
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.gatein.mop.core.api.workspace;

import org.chromattic.api.RelationshipType;
import org.chromattic.api.annotations.FormattedBy;
import org.chromattic.api.annotations.ManyToOne;
import org.chromattic.api.annotations.NamingPrefix;
import org.chromattic.api.annotations.OneToOne;
import org.chromattic.api.annotations.MappedBy;
import org.chromattic.api.annotations.Destroy;
import org.chromattic.api.annotations.Owner;
import org.chromattic.api.annotations.PrimaryType;
import org.chromattic.ext.format.BaseEncodingObjectFormatter;
import org.gatein.mop.api.workspace.Site;
import org.gatein.mop.api.workspace.Page;
import org.gatein.mop.api.workspace.ObjectType;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
@NamingPrefix("mop")
@FormattedBy(BaseEncodingObjectFormatter.class)
@PrimaryType(name = "mop:site")
public abstract class SiteImpl<C extends SiteContainer> extends WorkspaceObjectImpl implements Site
{

   @OneToOne
   @MappedBy("mop:rootpage")
   @Owner
   public abstract PageImpl getRoot();

   @OneToOne
   @MappedBy("mop:rootnavigation")
   @Owner
   public abstract NavigationImpl getRootNavigation();

   @ManyToOne
   public abstract C getSites();

   @Destroy
   public abstract void destroy();

   @OneToOne(type = RelationshipType.EMBEDDED)
   @Owner
   public abstract WorkspaceCustomizationContextImpl getCustomizationContext();

   public abstract ObjectType<? extends Site> getObjectType();

   // Site implementation ***********************************************************************************************

   public WorkspaceImpl getWorkspace()
   {
      SiteContainer sites = getSites();
      return sites.getWorkspace();
   }

   public Page getRootPage()
   {
      return getRoot();
   }
}
