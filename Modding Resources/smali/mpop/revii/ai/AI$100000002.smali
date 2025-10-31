.class Lmpop/revii/ai/AI$100000002;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000002"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmpop/revii/ai/AI$100000002$100000001;
    }
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;

.field private final val$ctx:Landroid/content/Context;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000002;->val$ctx:Landroid/content/Context;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000002;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 235
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->tts:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->isSpeaking()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 236
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->tts:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->stop()I

    .line 238
    :cond_0
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    .line 239
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 240
    iget-object v1, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, v1, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    iget-object v2, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000002;->val$ctx:Landroid/content/Context;

    iget-object v4, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v5, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v5, v5, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "USERNAME"

    invoke-static {v5, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v6}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4, v0}, Lmpop/revii/ai/AI;->chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 241
    new-instance v1, Lmpop/revii/ai/connection;

    iget-object v2, p0, Lmpop/revii/ai/AI$100000002;->val$ctx:Landroid/content/Context;

    invoke-direct {v1, v2}, Lmpop/revii/ai/connection;-><init>(Landroid/content/Context;)V

    .line 242
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    aput-object v0, v2, v7

    const/4 v0, 0x1

    iget-object v3, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v3, v3, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v4, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v5, "USERNAME"

    invoke-static {v4, v5}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v5}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-virtual {v1, v2}, Lmpop/revii/ai/connection;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 243
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, v1, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lmpop/revii/ai/AI;->lq:Ljava/lang/String;

    .line 244
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 245
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v0, v7}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 246
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    iput-boolean v7, v0, Lmpop/revii/ai/AI;->replied:Z

    .line 251
    :goto_0
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lmpop/revii/ai/AI$100000002$100000001;

    invoke-direct {v1, p0}, Lmpop/revii/ai/AI$100000002$100000001;-><init>(Lmpop/revii/ai/AI$100000002;)V

    const/16 v2, 0x64

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    .line 249
    :cond_1
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002;->this$0:Lmpop/revii/ai/AI;

    invoke-virtual {v0}, Lmpop/revii/ai/AI;->speak()V

    goto :goto_0
.end method
