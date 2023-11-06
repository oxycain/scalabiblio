import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.util.{Failure, Success, Try}


class BibliothequeSpec extends AnyFlatSpec with Matchers {

  "Une bibliothèque" should "permettre d'ajouter un livre" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = false)
    bibliotheque.ajouterLivre(livre)
    val livreAjoute = bibliotheque.rechercherParTitre("Titre du livre")
    livreAjoute should not be None
    livreAjoute.get should be(livre)
  }

  it should "permettre d'emprunter un livre non emprunté" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = false)
    bibliotheque.ajouterLivre(livre)
    val resultat = bibliotheque.emprunterLivre("Titre du livre")
    resultat should be(Success(()))
    val livreEmprunte = bibliotheque.rechercherParTitre("Titre du livre")
    livreEmprunte.get.estEmprunte should be(true)
  }

  it should "renvoyer une erreur lorsqu'on essaie d'emprunter un livre déjà emprunté" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = true)
    bibliotheque.ajouterLivre(livre)
    val resultat = bibliotheque.emprunterLivre("Titre du livre")
    resultat should matchPattern { case Failure(_) => }
  }

  it should "renvoyer une erreur lorsqu'on essaie d'emprunter un livre non trouvé" in {
    val bibliotheque = new Bibliotheque()
    val resultat = bibliotheque.emprunterLivre("Titre du livre inexistant")
    resultat should matchPattern { case Failure(_) => }
  }

  it should "permettre de rendre un livre emprunté" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = true)
    bibliotheque.ajouterLivre(livre)
    val resultat = bibliotheque.rendreLivre("Titre du livre")
    resultat should be(Success(()))
    val livreRendu = bibliotheque.rechercherParTitre("Titre du livre")
    livreRendu.get.estEmprunte should be(false)
  }

  it should "renvoyer une erreur lorsqu'on essaie de rendre un livre non emprunté" in {
    val bibliotheque = new Bibliotheque()
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = false)
    bibliotheque.ajouterLivre(livre)
    val resultat = bibliotheque.rendreLivre("Titre du livre")
    resultat should matchPattern { case Failure(_) => }
  }

  it should "renvoyer une erreur lorsqu'on essaie de rendre un livre non trouvé" in {
    val bibliotheque = new Bibliotheque()
    val resultat = bibliotheque.rendreLivre("Titre du livre inexistant")
    resultat should matchPattern { case Failure(_) => }
  }
}
