import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class LivreSpec extends AnyFlatSpec with Matchers {
  "Un livre" should "être empruntable" in {
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = false)
    livre.emprunter()
    livre.estEmprunte should be(true)
  }

  it should "pouvoir être rendu" in {
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = true)
    livre.rendre()
    livre.estEmprunte should be(false)
  }

  it should "être affiché correctement sous forme de chaîne de caractères" in {
    val livre = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = true)
    val expectedString = "Titre du livre;Auteur du livre;2023;true"
    livre.toString should be(expectedString)
  }

  it should "être égal à un autre livre ayant les mêmes attributs" in {
    val livre1 = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = true)
    val livre2 = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = true)
    livre1 should be(livre2)
  }

  it should "être différent d'un autre livre ayant des attributs différents" in {
    val livre1 = new Livre("Titre du livre", "Auteur du livre", 2023, estEmprunte = true)
    val livre2 = new Livre("Autre titre", "Autre auteur", 2022, estEmprunte = false)
    livre1 should not be livre2
  }
}