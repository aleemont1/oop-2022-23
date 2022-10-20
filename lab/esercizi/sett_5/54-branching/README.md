### Si crei una nuova directory
mkdir foo
### Si inizializzi un repository Git dentro la cartella suddetta.
cd foo && git init 
### Si osservi lo stato del repository
git status
### Si scriva un file `HelloWorld.java` contenente un `main` con una stampa a video e si osservi il contenuto del repository
touch HelloWorld.java
$EDITOR HelloWorld.java
ls -lah
Size User     Date Modified Name
   - aleemont 13 Oct 17:07   .
   - aleemont 13 Oct 14:29   ..
   - aleemont 13 Oct 17:07   .git
   - aleemont 13 Oct 17:10   foo
2.2k aleemont 13 Oct 17:09   README.md
git status
On branch main
Your branch is up to date with 'origin/main'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
       ./

no changes added to commit (use "git add" and/or "git commit -a")


### Si aggiunga `HelloWorld.java` allo stage, e si osservi lo stato del repository
git add HelloWorld.java
git status

On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   HelloWorld.java
### Si crei il primo commit, con messaggio ragionevole. Se necessario, si configuri nome utente ed email di git usando i dati dell'account istituzionale.
git commit -m "created HelloWorld.java"
[43-git 8228c6c] created HelloWorld.java
 1 file changed, 5 insertions(+)
 create mode 100644 lab/esercizi/sett_4/43-git/foo/HelloWorld.java
### Si compili il file Java e si verifichi lo stato del repository
javac HelloWorld.java
### Si noti che c'è un file rigenerabile (`HelloWorld.class`). Si costruisca una lista di file ignorati che ignori tutti i file con estensione `.class`
touch .gitignore && echo "*.class" >> .gitignore
### Si osservi lo stato del repository
git status
On branch main

nothing to commit, working tree clean
### Si crei un nuovo commit che tracci il la ignore list, aggiungendo allo stage i file necessari. Si osservi sempre lo stato del repository dopo l'esecuzione di un comando
git add .gitignore
git status
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitignore

no changes added to commit (use "git add" and/or "git commit -a")

git commit -m "Added .gitignore"
### Si gestiscano i caratteri di fine linea in modo appropriato, creando un file `.gitattributes`
$EDITOR .gitattributes
### Si osservi la storia del repository usando `git log --all --graph`
git log --all --graph

* commit 92d57fe28aeaf3a8883489dfb42cc2e0dfe61ab9 (HEAD -> 43-git, origin/main)
| Author: Alessandro Monticelli <alessandr.monticell4@studio.unibo.it>
| Date:   Thu Oct 13 17:21:47 2022 +0200
| 
|     Completing ex 43
| 
* commit 8228c6c36c449e02ebdd2e5c1562c72f3e03b587
  Author: Alessandro Monticelli <alessandr.monticell4@studio.unibo.it>
  Date:   Thu Oct 13 17:18:40 2022 +0200
 
      created HelloWorld.java

### Da questo punto in poi, prima e dopo ogni comando, ci si assicuri di osservare lo stato del repository con `git status`

### Si crei un file Mistake.java, con contenuto arbitrario, lo si aggiunga al tracker, e si faccia un commit
touch Mistake.java
git add Mistake.java
git status

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   Mistake.java
git commit -m "created Mistake.java"

git commit -m "created Mistake.java"
[43-git fa2675c] created Mistake.java
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 lab/esercizi/sett_4/43-git/foo/Mistake.java

### Si rinomini `Mistake.java` in `ToDelete.java`, e si faccia un commit che registra la modifica
git add Mistake.java ToDelete.java

git status

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        renamed:    Mistake.java -> ToDelete.java


### Si elimini `ToDelete.java` e si registri la modifica in un commit
rm -rf ToDelete.java
git add ToDelete.java
git status

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        deleted:    Mistake.java

git commit -m "deleted ToDelete"
[43-git 4860a66] deleted ToDelete
 1 file changed, 0 insertions(+), 0 deletions(-)
 delete mode 100644 lab/esercizi/sett_4/43-git/foo/Mistake.java

### Si osservi la storia del repository e si identifichi il commit dove è stato creato `Mistake.java`. Per una visione compatta, si usi l'opzione `--oneline`

git log --all --oneline --graph
* 4860a66 (HEAD -> 43-git) deleted ToDelete
* fa2675c created Mistake.java
* 92d57fe (origin/main) Completing ex 43
* 8228c6c created HelloWorld.java

### Si ripristini Mistake.java dal commit identificato al passo precedente
git checkout fa2675c -- Mistake.java
git status
On branch 43-git

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   Mistake.java
### Si rimuova il file ripristinato e si ripulisca lo stage
git reset Mistake.java
git status

git status
 On branch 43-git
 Untracked files:
   (use "git add <file>..." to include in what will be committed)
   Mistake.java
nothing added to commit but untracked files present (use "git add" to track)
 
rm Mistake.java

git status
On branch 43-git
 nothing to commit, working tree clean

### Si torni al commit precedente a quello in cui `Mistake.java` è stato creato. Si utilizzi la storia del repository se utile.
git log --all --oneline --graph
* 4860a66 (HEAD -> 43-git) deleted ToDelete
* fa2675c created Mistake.java
* 92d57fe (origin/main) Completing ex 43
* 8228c6c created HelloWorld.java

git checkout 92d57fe

Note: switching to '92d57fe'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.
### Si crei un nuovo branch di nome `experiment` e si agganci la `HEAD` al nuovo branch
git branch -m experiment
git checkout experiment
### Si crei un file README.md con contenuto a piacere, e si faccia un commit che lo includa
touch README.md
git add README.md
git commit -m "Created README.md"

### Si torni sul branch master e si elenchino i branch disponibili
git checkout main
### Si unisca il branch experiment al branch master (si faccia un merge in cui experiment viene messo dentro master, e non viceversa)
git merge experiment
### Si osservi la storia del repository
