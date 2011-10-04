package org.kevoree

import java.io.File
import org.kevoree.serializer.ModelSerializer
import xml.PrettyPrinter

/**
 * Created by IntelliJ IDEA.
 * User: duke
 * Date: 03/10/11
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */

object Tester extends App {
  val current = System.currentTimeMillis()
  val localModel = ContainerRootLoader.loadModel(new File(("/Users/duke/Documents/dev/dukeboard/kevoree-extra/org.kevoree.extra.ecore.loader.test/src/test/resources/defaultLibrary.kev")));

  localModel match {
    case Some(m) => {
      println(System.currentTimeMillis() - current)

      println("====Debug")
      m.getTypeDefinitions.foreach{
        typed => typed.getDeployUnits.foreach{ tdeploy =>
           println(typed.getName+"=>"+tdeploy.getUnitName)
        }
      }
      println("*******Debug")
      val serializer = new ModelSerializer
      val pp = new PrettyPrinter(3000,1)
      val result = serializer.serialize(m)
      println(pp.format(result))
    }
    case None =>
  }
}