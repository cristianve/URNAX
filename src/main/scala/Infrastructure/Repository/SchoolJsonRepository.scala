package com.redgroup.votox
package Infrastructure.Repository

import Domain.Repositories.LocationRepository
import Domain.School

import io.circe._
import io.circe.generic.auto._

import scala.io.BufferedSource


class SchoolJsonRepository extends LocationRepository {

  val path: String = getClass.getResource("/schools.json").getPath;

  override def Get(postalCode: String): School = {

    val source: BufferedSource = scala.io.Source.fromFile(path)

    val lines = try source.mkString finally source.close()

    parser.decode[List[School]](lines) match {
      case Right(schools) => schools.find(p => {
        p.direction.postalCode == postalCode
      }).orNull
      case Left(ex) => null
    }
  }

}
