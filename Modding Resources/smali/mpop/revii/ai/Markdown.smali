.class public Lmpop/revii/ai/Markdown;
.super Landroid/widget/TextView;
.source "Markdown.java"


# instance fields
.field _text:Ljava/lang/String;

.field bgCode:Ljava/lang/String;

.field blockquote:Ljava/lang/String;

.field codes:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field ctx:Landroid/content/Context;

.field lang:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field mark:Ljava/lang/String;

.field noCode:Ljava/lang/String;

.field quote:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->_text:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->noCode:Ljava/lang/String;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->codes:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->lang:Ljava/util/ArrayList;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->blockquote:Ljava/lang/String;

    const-string v0, "#ccff20"

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->mark:Ljava/lang/String;

    const-string v0, "#303030"

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->bgCode:Ljava/lang/String;

    const-string v0, "#ffffff"

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->quote:Ljava/lang/String;

    .line 28
    invoke-virtual {p0, p1}, Lmpop/revii/ai/Markdown;->setup(Landroid/content/Context;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->_text:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->noCode:Ljava/lang/String;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->codes:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->lang:Ljava/util/ArrayList;

    const-string v0, ""

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->blockquote:Ljava/lang/String;

    const-string v0, "#ccff20"

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->mark:Ljava/lang/String;

    const-string v0, "#303030"

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->bgCode:Ljava/lang/String;

    const-string v0, "#ffffff"

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->quote:Ljava/lang/String;

    .line 33
    invoke-virtual {p0, p1}, Lmpop/revii/ai/Markdown;->setup(Landroid/content/Context;)V

    return-void
.end method

.method private code(Ljava/lang/String;)Landroid/text/Spanned;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 262
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 263
    const-string v1, "```"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 264
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 265
    new-instance v2, Landroid/text/style/BackgroundColorSpan;

    const-string v3, "%s90"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lmpop/revii/ai/Markdown;->bgCode:Ljava/lang/String;

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-direct {v2, v3}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    .line 266
    invoke-virtual {v1}, Landroid/text/SpannableString;->length()I

    move-result v3

    const/16 v4, 0x21

    invoke-virtual {v1, v2, v6, v3, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 267
    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 269
    :cond_0
    return-object v0
.end method

.method private scan(Ljava/lang/String;)Landroid/text/Spanned;
    .locals 10

    .prologue
    const/16 v9, 0x21

    const/4 v1, 0x0

    .line 192
    const/4 v0, 0x0

    check-cast v0, Landroid/text/Spanned;

    .line 196
    const-string v0, "^###### (.*)$"

    const-string v2, "<h6 style=\"margin: 0; padding: 0;\">$1</h6>"

    invoke-virtual {p1, v0, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 197
    const-string v2, "^##### (.*)$"

    const-string v3, "<h5 style=\"margin: 0; padding: 0;\">$1</h5>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 198
    const-string v2, "^#### (.*)$"

    const-string v3, "<h4 style=\"margin: 0; padding: 0; font-family: monospace;\">$1</h4>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 199
    const-string v2, "^### (.*)$"

    const-string v3, "<h3 style=\"margin: 0; padding: 0; font-family: serif;\">$1</h3>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 200
    const-string v2, "^## (.*)$"

    const-string v3, "<h2 style=\"margin: 0; padding: 0;\">$1</h2>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 201
    const-string v2, "^# (.*)$"

    const-string v3, "<h1 style=\"margin: 0; padding: 0;\">$1</h1>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 205
    const-string v2, "\\*\\*(.*?)\\*\\*"

    const-string v3, "<strong style=\"margin: 0; padding: 0;\">$1</strong>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 206
    const-string v2, "__(.*?)__"

    const-string v3, "<strong style=\"margin: 0; padding: 0;\">$1</strong>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 210
    const-string v2, "\\*(.*?)\\*"

    const-string v3, "<em style=\"margin: 0; padding: 0;\">$1</em>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 211
    const-string v2, "_(.*?)_"

    const-string v3, "<em style=\"margin: 0; padding: 0;\">$1</em>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 215
    const-string v2, "\\~\\~(.*?)\\~\\~"

    const-string v3, "<s style=\"margin: 0; padding: 0;\">$1</s>"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 219
    const-string v2, "\t"

    const-string v3, "&emsp;"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 220
    const-string v2, "\t"

    const-string v3, "&emsp;"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 221
    const-string v2, "    "

    const-string v3, "&emsp;"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 222
    const-string v2, "  "

    const-string v3, "&emsp;"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 226
    const-string v2, "^\\* (.*)"

    const-string v3, "&ensp;•&ensp;$1"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 230
    const-string v2, "`(.*?)`"

    const-string v3, "<font face=\"serif\" color=\"%s\"><u>$1</u></font>"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lmpop/revii/ai/Markdown;->mark:Ljava/lang/String;

    aput-object v5, v4, v1

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 233
    const-string v2, "\\>"

    const-string v3, "&gt;"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 234
    const-string v2, "\\<"

    const-string v3, "&lt;"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 236
    const-string v0, "&gt; "

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 237
    const-string v0, "&gt;"

    const-string v2, ">"

    invoke-virtual {v3, v0, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 238
    const-string v2, "&lt;"

    const-string v3, "<"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 239
    new-instance v0, Landroid/text/SpannableString;

    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    const-string v4, "&emsp;"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v3

    const-string v4, "> "

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 240
    new-instance v2, Landroid/text/style/QuoteSpan;

    iget-object v3, p0, Lmpop/revii/ai/Markdown;->quote:Ljava/lang/String;

    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v3

    invoke-direct {v2, v3}, Landroid/text/style/QuoteSpan;-><init>(I)V

    .line 241
    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v3

    invoke-virtual {v0, v2, v1, v3, v9}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 259
    :goto_0
    return-object v0

    .line 244
    :cond_0
    const-string v0, "\\s"

    invoke-virtual {v3, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 245
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2}, Landroid/text/SpannableStringBuilder;-><init>()V

    move v0, v1

    .line 251
    :goto_1
    array-length v5, v4

    if-lt v0, v5, :cond_1

    .line 254
    const-string v0, "&gt;"

    const-string v1, ">"

    invoke-virtual {v3, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 255
    const-string v1, "&lt;"

    const-string v3, "<"

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 256
    const/16 v1, 0x100

    invoke-static {v0, v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;I)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-object v0, v2

    .line 257
    goto :goto_0

    .line 246
    :cond_1
    aget-object v5, v4, v0

    .line 247
    const-string v6, "`"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    const-string v6, "`"

    invoke-virtual {v5, v6}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 248
    new-instance v6, Landroid/text/SpannableString;

    const-string v7, "`"

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    invoke-virtual {v5, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 249
    new-instance v5, Landroid/text/style/BackgroundColorSpan;

    const-string v7, "#30303090"

    invoke-static {v7}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v7

    invoke-direct {v5, v7}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    .line 250
    invoke-virtual {v6}, Landroid/text/SpannableString;->length()I

    move-result v7

    invoke-virtual {v6, v5, v1, v7, v9}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 251
    invoke-virtual {v2, v6}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method


# virtual methods
.method public getAllCodes()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 272
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->codes:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getLanguage()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 275
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->lang:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getWithoutCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->noCode:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Spanned;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setText(Ljava/lang/String;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 58
    :try_start_0
    const-string v0, "\n"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v9

    .line 59
    new-instance v10, Landroid/text/SpannableStringBuilder;

    invoke-direct {v10}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 61
    const-string v0, ""

    move v7, v3

    move v8, v3

    move v1, v3

    .line 108
    :goto_0
    array-length v2, v9

    if-lt v7, v2, :cond_0

    .line 110
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, v10}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {p0, v0}, Lmpop/revii/ai/Markdown;->setText(Ljava/lang/CharSequence;)V

    :goto_1
    return-void

    .line 63
    :cond_0
    aget-object v2, v9, v7

    .line 64
    const-string v5, "```"

    invoke-virtual {v2, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 65
    const-string v5, "```"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    if-nez v1, :cond_7

    .line 66
    :cond_1
    const-string v5, "```"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 67
    const-string v5, "```"

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v2, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    .line 68
    const-string v2, "html css js"

    .line 69
    invoke-virtual {v2, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 70
    invoke-virtual {v5}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-object v2, v5

    .line 82
    :cond_2
    iget-object v5, p0, Lmpop/revii/ai/Markdown;->lang:Ljava/util/ArrayList;

    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 91
    :goto_2
    if-eqz v1, :cond_8

    move v1, v3

    .line 108
    :cond_3
    :goto_3
    add-int/lit8 v5, v8, 0x1

    add-int/lit8 v2, v7, 0x1

    move v7, v2

    move v8, v5

    goto :goto_0

    .line 72
    :cond_4
    const-string v2, ""

    move v6, v3

    .line 73
    :goto_4
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v11

    if-ge v6, v11, :cond_2

    .line 74
    const-string v11, ""

    if-ne v2, v11, :cond_5

    .line 75
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v11, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v5, v6}, Ljava/lang/String;->charAt(I)C

    move-result v11

    invoke-static {v11}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v2, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    .line 73
    :goto_5
    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    .line 77
    :cond_5
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v11, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v5, v6}, Ljava/lang/String;->charAt(I)C

    move-result v11

    invoke-static {v11}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v2, v11}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_5

    .line 84
    :cond_6
    iget-object v2, p0, Lmpop/revii/ai/Markdown;->lang:Ljava/util/ArrayList;

    const-string v5, "Unknown Language"

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 110
    :catch_0
    move-exception v0

    goto/16 :goto_1

    .line 87
    :cond_7
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    .line 88
    iget-object v2, p0, Lmpop/revii/ai/Markdown;->codes:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 89
    const-string v0, ""

    goto :goto_2

    :cond_8
    move v1, v4

    .line 91
    goto :goto_3

    .line 93
    :cond_9
    if-eqz v1, :cond_a

    .line 94
    invoke-direct {p0, v2}, Lmpop/revii/ai/Markdown;->code(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v5

    .line 95
    invoke-virtual {v10, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 96
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v5, "%s \n"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v2, v6, v11

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    .line 97
    array-length v2, v9

    add-int/lit8 v2, v2, -0x1

    if-ge v8, v2, :cond_3

    .line 98
    const-string v2, "<br>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v10, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto/16 :goto_3

    .line 101
    :cond_a
    invoke-direct {p0, v2}, Lmpop/revii/ai/Markdown;->scan(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 102
    invoke-virtual {v10, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 103
    array-length v5, v9

    add-int/lit8 v5, v5, -0x1

    if-ge v8, v5, :cond_b

    .line 104
    const-string v5, "<br>"

    invoke-static {v5}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v5

    invoke-virtual {v10, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 106
    :cond_b
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    iget-object v6, p0, Lmpop/revii/ai/Markdown;->noCode:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    invoke-interface {v2}, Landroid/text/Spanned;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v6, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v6, "\n"

    invoke-virtual {v2, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lmpop/revii/ai/Markdown;->noCode:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_3
.end method

.method setup(Landroid/content/Context;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 37
    iput-object p1, p0, Lmpop/revii/ai/Markdown;->ctx:Landroid/content/Context;

    .line 38
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->codes:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_0

    .line 39
    invoke-virtual {p0, v1}, Lmpop/revii/ai/Markdown;->setClickable(Z)V

    .line 40
    invoke-virtual {p0, v1}, Lmpop/revii/ai/Markdown;->setTextIsSelectable(Z)V

    .line 41
    invoke-virtual {p0, v1}, Lmpop/revii/ai/Markdown;->setLinksClickable(Z)V

    .line 46
    :cond_0
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->ctx:Landroid/content/Context;

    const-string v1, "blockquote"

    iget-object v2, p0, Lmpop/revii/ai/Markdown;->blockquote:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->blockquote:Ljava/lang/String;

    .line 47
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->ctx:Landroid/content/Context;

    const-string v1, "mark"

    iget-object v2, p0, Lmpop/revii/ai/Markdown;->mark:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->mark:Ljava/lang/String;

    .line 48
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->ctx:Landroid/content/Context;

    const-string v1, "codebg"

    iget-object v2, p0, Lmpop/revii/ai/Markdown;->bgCode:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->bgCode:Ljava/lang/String;

    .line 49
    iget-object v0, p0, Lmpop/revii/ai/Markdown;->ctx:Landroid/content/Context;

    const-string v1, "quote"

    iget-object v2, p0, Lmpop/revii/ai/Markdown;->quote:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lmpop/revii/ai/util;->tocolor(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmpop/revii/ai/Markdown;->quote:Ljava/lang/String;

    .line 51
    invoke-virtual {p0}, Lmpop/revii/ai/Markdown;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 52
    const-string v1, ""

    invoke-virtual {p0, v1}, Lmpop/revii/ai/Markdown;->setText(Ljava/lang/String;)V

    .line 53
    invoke-virtual {p0, v0}, Lmpop/revii/ai/Markdown;->setText(Ljava/lang/String;)V

    return-void
.end method
