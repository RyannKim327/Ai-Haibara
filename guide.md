### AI Haibara
#### MPOP Reverse II [RyannKim327]

---
### How to
> This is how to implement this application, as a feature into your android app:

1. Extract all files
> The most important thing you need is to get first the files. `Adapter`, `AI`, `http`, `Markdown` and `util` and other smali files related to this except `MainActivity` and `Overlay`. Also, you need to extrant and have `ic_microphone` and `ic_send` under drawable folder.
2. Customization
> You may customize the color based on what you want, just click [Chat palette](#chat-color-palette) for the names and purpose.
3. Self and optional information
> You may add your name here as app modder, also your message. For references click [This Section](#informations)
4. Implementation
> If everything is good and enough, you may now apply it to your app. Also you may now decompile.

---
### Informations
> This section is to customized the modder's information and identity. **NOTE** that this must be saved in the `strings.xml` in the values folder.

1. modder - For your name, just insert your name there and the system will generate the format.
2. message - Your message to your users.

---
### Chat Color Palette
> Here are the lists of names you need to customized this chat. **NOTE** that this must be saved in the `strings.xml` in values folder.

#### AI Preference
1. maincolor  - main background
2. mainchatbox - main input box
3. selfchat - your chat bubble color
4. selfchatc - your chat text color
5. aichat - ai chat bubble color
6. aichatc - ai chat text color

#### Markdown Preference
1. codebg - background color of the code
2. mark - color of the highlighted text
3. quote - color for blockquote left border