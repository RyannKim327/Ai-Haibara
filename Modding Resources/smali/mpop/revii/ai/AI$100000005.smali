.class Lmpop/revii/ai/AI$100000005;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Landroid/speech/RecognitionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000005"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmpop/revii/ai/AI$100000005$100000004;
    }
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;

.field private final val$ctx:Landroid/content/Context;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000005;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onBeginningOfSpeech()V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method

.method public onBufferReceived([B)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method

.method public onEndOfSpeech()V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method

.method public onError(I)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 309
    packed-switch p1, :pswitch_data_0

    .line 327
    :goto_0
    :pswitch_0
    return-void

    .line 311
    :pswitch_1
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    const-string v1, "Audio Error"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 314
    :pswitch_2
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    const-string v1, "Client Error"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 317
    :pswitch_3
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    const-string v1, "Network Error"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 320
    :pswitch_4
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    const-string v1, "Speech Recognizer is busy"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 323
    :pswitch_5
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    const-string v1, "Network Timeout"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 326
    :pswitch_6
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    const-string v1, "Speech Timeout"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 309
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_5
        :pswitch_3
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_6
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method

.method public onEvent(ILandroid/os/Bundle;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method

.method public onPartialResults(Landroid/os/Bundle;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method

.method public onReadyForSpeech(Landroid/os/Bundle;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 297
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->val$ctx:Landroid/content/Context;

    const-string v1, "Starting"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->show(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    return-void
.end method

.method public onResults(Landroid/os/Bundle;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 334
    const-string v0, "results_recognition"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    .line 335
    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-eqz v0, :cond_0

    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v2, ""

    if-eq v0, v2, :cond_0

    .line 336
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, v0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v5, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v5, v5, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "USERNAME"

    invoke-static {v5, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v6}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v4, v5, v0}, Lmpop/revii/ai/AI;->chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 337
    new-instance v2, Lmpop/revii/ai/connection;

    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    invoke-direct {v2, v0}, Lmpop/revii/ai/connection;-><init>(Landroid/content/Context;)V

    .line 338
    const/4 v0, 0x2

    new-array v3, v0, [Ljava/lang/Object;

    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v3, v7

    const/4 v0, 0x1

    iget-object v1, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, v1, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v4, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v5, "USERNAME"

    invoke-static {v4, v5}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v5}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v0

    invoke-virtual {v2, v3}, Lmpop/revii/ai/connection;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 339
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v1, v1, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lmpop/revii/ai/AI;->lq:Ljava/lang/String;

    .line 340
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 341
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v0, v7}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 342
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005;->this$0:Lmpop/revii/ai/AI;

    iput-boolean v7, v0, Lmpop/revii/ai/AI;->replied:Z

    .line 343
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lmpop/revii/ai/AI$100000005$100000004;

    invoke-direct {v1, p0}, Lmpop/revii/ai/AI$100000005$100000004;-><init>(Lmpop/revii/ai/AI$100000005;)V

    const/16 v2, 0x64

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_0
    return-void
.end method

.method public onRmsChanged(F)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(F)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    return-void
.end method
