# General overview

This is a maze-based game where the objective is to go through the dungeons and halls collecting keys in ascending order (from 1-9) while having random encounters with enemies along the way.

Your party is represented by a a series of "@" signs which look sort of like a snake and moves like a snake throughout the map. Whenever a member of your party is killed off, the tail of your snake is removed until everyone is killed off and you lose.

# How to play

## Party selection

To add members to your party use the number keys at the party selection screen. Your overall party will be reflected below the last choice. After you've selected everyone you'd like to be a part of your journey, hit the "C" key to continue.

## Collecting keys

Adventure through the dungeons and halls to find your first key, which is just the number "1". Locked keys will have a border around them while unlocked keys will not. A key will only become unlocked when you find its preceding key. For example, "3" will remain locked until you find "2", which will remain locked until you find "1".

## Combat system

# Technical aspects


## Language
This game was written in Java using the [Blacken](code.google.com/p/blacken/) libray. They had awesome [examples](https://code.google.com/p/blacken/downloads/list) which happened to include a Dungeon sample which we used as the base for this game.

## VCS

We used Git for maintaining versions and branches. You can find the full revision history and project source code on [GitHub in the landaire/cscd349-proj repository](https://github.com/landaire/cscd349-proj).