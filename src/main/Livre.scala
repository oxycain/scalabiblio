class Livre(var titre: String, var auteur: String, var anneeDePublication: Int, var estEmprunte: Boolean) {
  def emprunter(): Unit = {
    if (!estEmprunte) {
      estEmprunte = true
      println(s"$titre a été emprunté.")
    } else {
      println(s"$titre est déjà emprunté.")
    }
  }

  def rendre(): Unit = {
    if (estEmprunte) {
      estEmprunte = false
      println(s"$titre a été rendu.")
    } else {
      println(s"$titre n'est pas emprunté.")
    }
  }

  override def toString: String = s"$titre;$auteur;$anneeDePublication;$estEmprunte"

  override def equals(other: Any): Boolean = other match {
    case that: Livre =>
      this.titre == that.titre &&
        this.auteur == that.auteur &&
        this.anneeDePublication == that.anneeDePublication &&
        this.estEmprunte == that.estEmprunte
    case _ => false
  }
}
