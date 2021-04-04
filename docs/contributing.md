# Contributing

Helping out with the project!

## Example Project Code

If you make Example Project Code changes please contribute changes that reflect this in the Documentation. This will make it easier for us and more likely that your contribution will be approved.

## Documentation

If you make documentation changes please contribute changes that reflect this in the Example Project Code. This will make it easier for us and more likely that your contribution will be approved.

There are a couple of ways to contribute to this project:

- [Via the web](#via-the-web)
- [Via local source](#via-local-source)

***

## Via the web

### Editing Pages

On each page there is an option to edit the page. Any changes you make through this option will be submitted and become live once they are approved.  

> The edit icon looks like this:
> 
> ![](assets/images/contributing/edit_icon.png)

Alternatively you could create a pull request and clone the repository

### New Pages

You can help the project by making new pages. Any pages you make will become live once they are approved.  

[Click here to create a new page](https://github.com/FRCTeam3255/FRC-Java-Tutorial/new/main/Docs_Source/docs){target=_blank}

Please use the [New Page Template](#new-page-template)

[Click here to see tips on creating markdown documents](https://www.markdownguide.org/cheat-sheet/){target=_blank}

!!! Warning
    Make sure all documentation files end in `.md`

!!! Tip
    You can add to a certain tab by appending `/tab_name/` to the file name

!!! Tip
    Visit [Admonitions (call-out) references](https://squidfunk.github.io/mkdocs-material/reference/admonitions/) for a list off call-outs like this one.

***

## Via local source

### Prerequisites

1. [Install GitHub Desktop](https://desktop.github.com){target=_blank} (Beginner) or [Install Git](https://git-scm.com){target=_blank} (Expert)
2. [Install Python](https://www.python.org){target=_blank}
3. [Install pip requirements](https://raw.githubusercontent.com/FRCTeam3255/FRC-Java-Tutorial/main/Docs_Source/requirements.txt){target=_blank}
      1. Run one of the following commands. Try each one in order until successful.
         - `pip install -r requirements.txt` 
         - `python -m pip install -r requirements.txt` 
         - `py -m pip install -r requirements.txt`

### Creating local edits

1. Visit <https://github.com/FRCTeam3255/FRC-Java-Tutorial/tree/main/> and fork the repository.
2. Clone your the newly created fork to your machine and open it
3. Run the command `mkdocs serve` to open up a live local version of the project in your browser
   - If `mkdocs serve` does not work on its own, try each one in order until successful:
     - `python -m mkdocs serve` 
     - `py -m mkdocs serve`
4. Make your changes or additions in the `docs` directory.
   - Please maintain the organizational folder structure.
5. If added a new page, add the relative url to the `mkdocs.yml` file in the `# Navigation` (`nav:`) section.
   1. For new pages please use the [New Page Template](#new-page-template)
   2. [Click here to see tips on creating markdown documents](https://www.markdownguide.org/cheat-sheet/){target=_blank}

### Pushing your local edits to the web

1. Commit your changes
2. Push your changes to GitHub
3. Back on the webpage for your fork of the project select Pull Request
   1. Create a new pull request
4. Wait for the pull request to be approved.

***

## New Page Template

Please copy this code as a template to create your new page

```markdown
# Page title
<!-- This page was contributed by:  -->

Subtitle

<!-- Add a page image to make it pretty! -->
![Image Title](imageURL)

## Overview

This section will help you learn to BLANK.

**See table of contents for a breakdown of this section.**

***

## Section One

- Some info
- Some other into
    - Some sub info

### Section One Subsection

***

## Section Two

- Info
- Info 2

!!! Tip
    This is a tip.
```
