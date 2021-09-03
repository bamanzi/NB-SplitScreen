# NB-SplitScreen

Netbeans plugin - Split screen (TabGroupSwitch)

This allows you to use split screen conveniently.

This plugin is just two changeable shortcuts.

One cycles through all opened document tab groups, switching active file, therefore the cursor (caret, insertion point).
Second moves the active opened file into the next tab group, allowing you to move opened files without touching the mouse...

You can change these shortcuts in *Options* > *Keymap*.
Actions can also be found under *Navigate* > *Go to next tab group*
and *Window* > *Dock current file into next tab group*

Note for developers: The action redocking the file creates clone of the TopComponent, meaning its different instance!

Please, feel free to request future features or ask any questions.

http://plugins.netbeans.org/plugin/59417/split-screen-tabgroupswitch
