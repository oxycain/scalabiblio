import scala.util.{Failure, Success, Try}
import scala.collection.mutable.ListBuffer
import scala.io.Source
class Bibliotheque {
  private val listeDeLivres: ListBuffer[Livre] = ListBuffer()

  def ajouterLivre(livre: Livre): Unit = {
    listeDeLivres += livre
    println(s"${livre.titre} a été ajouté à la bibliothèque.")
  }

  def emprunterLivre(titre: String): Try[Unit] = {
    val livreOpt = listeDeLivres.find(_.titre.equalsIgnoreCase(titre))
    livreOpt match {
      case Some(livre) if !livre.estEmprunte =>
        livre.emprunter()
        Success(())
      case Some(_) =>
        Failure(new Exception("Le livre est déjà emprunté."))
      case None =>
        Failure(new Exception("Livre non trouvé."))
    }
  }

  def rendreLivre(titre: String): Try[Unit] = {
    val livreOpt = listeDeLivres.find(_.titre.equalsIgnoreCase(titre))
    livreOpt match {
      case Some(livre) if livre.estEmprunte =>
        livre.rendre()
        Success(())
      case Some(_) =>
        Failure(new Exception("Le livre n'est pas actuellement emprunté."))
      case None =>
        Failure(new Exception("Livre non trouvé."))
    }
  }

  def rechercherParAuteur(auteur: String): Option[Livre] = {
    listeDeLivres.find(_.auteur.toLowerCase == auteur.toLowerCase)
  }
  def rechercherParTitre(titre: String): Option[Livre] = {
    listeDeLivres.find(_.titre.toLowerCase == titre.toLowerCase)
  }


  def sauvegarderDansFichier(nomFichier: String): Unit = {
    val writer = new java.io.PrintWriter(new java.io.File(nomFichier))
    try {
      listeDeLivres.foreach(livre => writer.println(livre))
      println(s"Les données ont été sauvegardées dans $nomFichier (${listeDeLivres.length} livres).")
    } finally {
      writer.close()
    }
  }

  def chargerDepuisFichier(nomFichier: String): Unit = {
    val resourceStream = getClass.getResourceAsStream(nomFichier)
    if (resourceStream == null) {
      println(s"Le fichier $nomFichier n'est pas retrouvé.")
    } else {
      val source = Source.fromInputStream(resourceStream)
      for (line <- source.getLines) {
        val fields = line.split(";")
        if (fields.length == 4) {
          val titre = fields(0)
          val auteur = fields(1)
          val annee = fields(2).toInt
          val estEmprunte = fields(3).toBoolean
          val livre = new Livre(titre, auteur, annee, estEmprunte)
          ajouterLivre(livre)
        }
      }
      println(s"data loaded (${listeDeLivres.length})")
      source.close()
    }
  }

}
