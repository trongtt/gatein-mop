/*
 * Copyright (C) 2010 eXo Platform SAS.
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

import org.chromattic.api.annotations.MappedBy;
import org.chromattic.api.annotations.MixinType;
import org.chromattic.api.annotations.OneToOne;
import org.chromattic.api.annotations.Owner;
import org.gatein.mop.api.Scope;
import org.gatein.mop.api.workspace.Page;
import org.gatein.mop.api.workspace.Templatized;
import org.gatein.mop.core.api.PathAttribute;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
@MixinType(name = "mop:templatized")
public abstract class TemplatizedImpl implements Templatized
{

   @OneToOne
   @MappedBy("mop:template")
   @Owner
   public abstract PathAttribute getRelatedTemplate();

   public void setTemplate(Page template)
   {
      getRelatedTemplate().setValue(template);
   }

   public Page getTemplate()
   {
      return (Page)getRelatedTemplate().getValue();
   }

   public Scope getScope()
   {
      return getRelatedTemplate().getScope();
   }

   public void setScope(Scope scope)
   {
      getRelatedTemplate().setScope(scope);
   }
}
