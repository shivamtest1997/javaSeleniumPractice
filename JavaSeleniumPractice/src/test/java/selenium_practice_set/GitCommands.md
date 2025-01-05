# Git Commands

### Git Configuration

1. Set the name
   :  `git config --global user.name "username"`
   
2. Set the email
   : `git config --global user.email "shivamtest@gmail.com"`

3. check the setting
   : `git config --list `

4. Git alias :set up alias for each command
   : ` git config -- global alias.co checkout`
   : `git config --global alias.s status`
   : `git config --global alias.br branch`

### Starting a project

1. Git init - create local Repository
   : `git init <repoName>`

2. Git clone --make a copy of remote repository
   : `git clone <remoteUrl>`

### Local Changes

1. Git add --Add files to staging area 
   : `git add <fileName>`

2. Add All --Add all files to staging area
   : `git add*`

3. Git Commit --push changes to local repo with message 
   : `git commit -m "message"`

### Track Changes 

1. Track changes that have not been staged 
   : `git diff`

2. Track changes that have staged but not commited
   : `git diff --staged`

3. Track changes after commiting a file
   : `git diff HEAD`

4. Track changes between two commits
   : `git diff <commit1-sha><commit2-sha>`

5. Display the state of working directory and staging area
   : `git status`

### Commit History

1. Display most recent commits and status of head
   : `git log`

2. Display the output as one commit per line
   : `git log --oneline`

3. Display the files that have been modified
   : `git log --stat`

4. Display the modified files with location
   : `git log -p`

5. Display the modification on each line of file
   : git blame <fileName>

### Ignoring Files
 : .gitignore --specify intentionally untracked files that Git should ignore
 : create .gitignore:
   `touch .gitignore`

### Branching
1. Create branch
   : `git branch <branchName>`

2. List Branch
   : `git branch --list`

3. Delete Branch
   : `git branch -d <branchName>`

4. Delete Remote Branch
   : `git push origin --delete <branchName>`

5. Rename Branch
   : `git branch -m <oldBranchName> <newBranchName>`

6. Switch to a particular branch
   : `git checkout <branch Name>`

7. Create new branch and switch to it
   : `git checkout -b <branch name>`

8. Stash current work
   : `git stash`

9. Saving Stashes with message
   : `git stash save "stashing message"`

10. Check the stored stashes
   : `git stash list`

11. Reapply the stash that you just stashed
   : `git stash apply `

12. Re-apply the previous commit 
    : `git stash pop `

13. Delete all available stashes
    : `git stash clear`

### Merging  

1. Merge the branches
   : `git merge <branch name>`

2. Apply sequence of commits from district branches into a final commit
   : `git rebase <branch name>`
   : `git rebase --continue`
   : `git rebase --skip`

### Remote

1. Check configuration of remote 
   : `git remote -v `

2. Add remote for a repository
   : `git remote add origin <remote url>`
 
3. Fetch Data from remote
   : `git fetch <remote>`

4. Push data to remote server
   : `git push origin master`

5. Pull data from remote server
   : `git pull origin master`

### Revert and Reset
 : **Revert** : `git revert <commit id>`
 : This command is used to undo particular changes present into specified commit id
 : Note : after entering this command one window will appear which ask new commit message
   Hence we have to press 'i' to insert message
 : After inserting new message press 'Esc' button and enter ':wq' to get back to original window
   and push the changes into branch
 
 **Reset**  `git reset --hard <commit id>`
: This command is used to perform undo operation in such a way that we don't have commit id
   available after performing reset
