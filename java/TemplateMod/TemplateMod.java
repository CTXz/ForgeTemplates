/*
 * Copyright 2017 Patrick Pedersen <ctx.xda@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

 * ------------------------------------------------------------------------ *

 * Author:
 * Patrick Pedersen <ctx.xda@gmail.com>

  * Credit:
  * TheGreyGhost - For his MinecraftByExample project trough which
                   I've gained most of my current modding knwoledge.

 * Description:
 * Template for main/core mod class

 * About:
 * The main/core mod class acts as an entry point for the mod.
   A main/core mod class is indicated through the @Mod annotation
   which makes the forge build environment aware of the mod.

   For advanced programmers, one could imagine this class as the
   "main" class, or perhaps even, "main" method/function but rather
   than being executed as an application, it is picked up by the
   Forge Mod Loader (FML)

   The main/core class is primarily responsible for core Initialization,
   such as defining mod meta-data as well as instancing proxies and most
   importantly, handling FML Initialization events, which in this files
   case, initializes and boot-straps the Common Proxy.

 */

package templatemod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;

import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/* Let the Forge Builder know about this mod */
@Mod
(
  modid   = TemplateMod.MODID,
  name    = TemplateMod.MODNAME,
  version = TemplateMod.VERSION
)

/* Main Mod Class */
public class TemplateMod
{
  /* Define Meta Data */
  public static final String MODID   = "templatemod";
  public static final String MODNAME = "Template Mod";
  public static final String VERSION = "0.0.0";

  /* Create acessable Instance of this class */
   @Instance(MODID)
   public static TemplateMod instance;

   /* Tell Forge about the Client and Server Proxy Class */
   @SidedProxy(clientSide = "templatemod.ClientProxy", serverSide="templatemod.ServerProxy")
   public static CommonProxy proxy;

   /* On Pre-Initialization event */
   @EventHandler
   public void preInit(FMLPreInitializationEvent e)
   {
     /* ... */
     proxy.preInit();
     /* ... */
   }

   /* On Initialization event */
   @EventHandler
   public void preInit(FMLInitializationEvent e)
   {
     /* ... */
     proxy.init();
     /* ... */
   }

   /* On Post-Initialization event */
   @EventHandler
   public void preInit(FMLPostInitializationEvent e)
   {
     /* ... */
     proxy.postInit();
     /* ... */
   }
}
