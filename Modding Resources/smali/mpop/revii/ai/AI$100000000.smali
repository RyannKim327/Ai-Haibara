.class Lmpop/revii/ai/AI$100000000;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000000"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;

.field private final val$ctx:Landroid/content/Context;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000000;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/text/Editable;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            "III)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            "III)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    const v5, 0x1080050

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 175
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_2

    .line 176
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    const-string v3, "ic_send"

    const-string v4, "drawable"

    invoke-static {v0, v3, v4}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_1

    .line 177
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v0, v5}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 188
    :goto_0
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    .line 189
    const-string v3, ":preferences"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 190
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    invoke-virtual {v0}, Lmpop/revii/ai/AI;->preferences()V

    .line 191
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 210
    :cond_0
    :goto_1
    return-void

    .line 179
    :cond_1
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    const-string v4, "ic_send"

    const-string v5, "drawable"

    invoke-static {v3, v4, v5}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_0

    .line 182
    :cond_2
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    const-string v3, "ic_microphone"

    const-string v4, "drawable"

    invoke-static {v0, v3, v4}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_3

    .line 183
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v0, v5}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_0

    .line 185
    :cond_3
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    const-string v4, "ic_microphone"

    const-string v5, "drawable"

    invoke-static {v3, v4, v5}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_0

    .line 192
    :cond_4
    const-string v3, ":feedback"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 193
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const-string v2, ""

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 194
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setActivated(Z)V

    .line 195
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 196
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    invoke-virtual {v0}, Lmpop/revii/ai/AI;->feedback()V

    goto :goto_1

    .line 197
    :cond_5
    const-string v3, ":clear"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6

    const-string v3, ":cls"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 198
    :cond_6
    new-instance v0, Lmpop/revii/ai/connection;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    invoke-direct {v0, v3}, Lmpop/revii/ai/connection;-><init>(Landroid/content/Context;)V

    .line 199
    iget-object v3, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v3, v3, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 200
    iget-object v3, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v3, v3, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    iget-object v4, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v5, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    const-string v6, "Welcome [Bot]"

    iget-object v7, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    invoke-virtual {v7}, Lmpop/revii/ai/AI;->welcome()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v5, v6, v7}, Lmpop/revii/ai/AI;->chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 201
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const-string v4, "/delete"

    aput-object v4, v3, v1

    iget-object v4, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v5, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v5, v5, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "USERNAME"

    invoke-static {v5, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v6}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v2

    invoke-virtual {v0, v3}, Lmpop/revii/ai/connection;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 202
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const-string v2, ""

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 203
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-object v2, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    const-string v3, "USER_ID"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 204
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 205
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iput-boolean v1, v0, Lmpop/revii/ai/AI;->replied:Z

    goto/16 :goto_1

    .line 206
    :cond_7
    const-string v3, ":speech"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 207
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v3, v3, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v4, "TEXT_TO_SPEECH"

    invoke-static {v3, v4}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    .line 208
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v5, "TEXT_TO_SPEECH"

    invoke-static {v0, v5}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v3, :cond_8

    move v0, v1

    :goto_2
    invoke-interface {v4, v5, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 209
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    iget-object v5, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v6, p0, Lmpop/revii/ai/AI$100000000;->val$ctx:Landroid/content/Context;

    const-string v7, "Preferences [Text to Speech]"

    const-string v8, "Text to speech and speech to text is %s"

    new-array v2, v2, [Ljava/lang/Object;

    if-nez v3, :cond_9

    const-string v0, "enabled"

    :goto_3
    aput-object v0, v2, v1

    invoke-static {v8, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v6, v7, v0}, Lmpop/revii/ai/AI;->chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v4, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 210
    iget-object v0, p0, Lmpop/revii/ai/AI$100000000;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    :cond_8
    move v0, v2

    .line 208
    goto :goto_2

    .line 209
    :cond_9
    const-string v0, "disabled"

    goto :goto_3
.end method
