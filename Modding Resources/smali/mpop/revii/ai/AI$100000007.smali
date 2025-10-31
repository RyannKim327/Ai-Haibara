.class Lmpop/revii/ai/AI$100000007;
.super Landroid/content/BroadcastReceiver;
.source "AI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000007"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmpop/revii/ai/AI$100000007$100000006;
    }
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;

.field private final val$ctx:Landroid/content/Context;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000007;->val$ctx:Landroid/content/Context;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000007;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/content/Intent;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v7, 0x1

    move v0, v1

    .line 365
    :goto_0
    const/4 v2, 0x5

    if-ge v0, v2, :cond_0

    iget-object v2, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, v2, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v3, "CONNECTION_DATA"

    invoke-static {v2, v3}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "Question Error!"

    if-eq v2, v3, :cond_1

    .line 370
    :cond_0
    iget-object v0, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->sc2:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v2, p0, Lmpop/revii/ai/AI$100000007;->val$ctx:Landroid/content/Context;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v3, v3, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v4, "CONNECTION_SENDER"

    invoke-static {v3, v4}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v5, "CONNECTION_DATA"

    invoke-static {v4, v5}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lmpop/revii/ai/AI;->chat(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/LinearLayout;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 371
    iget-object v0, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->iv:Landroid/widget/ImageButton;

    invoke-virtual {v0, v7}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 372
    iget-object v0, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0, v7}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 373
    iget-object v0, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->e:Landroid/widget/EditText;

    invoke-virtual {v0, v7}, Landroid/widget/EditText;->setActivated(Z)V

    .line 374
    iget-object v0, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iput-boolean v7, v0, Lmpop/revii/ai/AI;->replied:Z

    .line 375
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lmpop/revii/ai/AI$100000007$100000006;

    invoke-direct {v1, p0}, Lmpop/revii/ai/AI$100000007$100000006;-><init>(Lmpop/revii/ai/AI$100000007;)V

    const/16 v2, 0xfa

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void

    .line 366
    :cond_1
    new-instance v2, Lmpop/revii/ai/connection;

    iget-object v3, p0, Lmpop/revii/ai/AI$100000007;->val$ctx:Landroid/content/Context;

    invoke-direct {v2, v3}, Lmpop/revii/ai/connection;-><init>(Landroid/content/Context;)V

    .line 367
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->lq:Ljava/lang/String;

    aput-object v4, v3, v1

    iget-object v4, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v4, v4, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    iget-object v5, p0, Lmpop/revii/ai/AI$100000007;->this$0:Lmpop/revii/ai/AI;

    iget-object v5, v5, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v6, "USERNAME"

    invoke-static {v5, v6}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lmpop/revii/ai/AI;->creator:[I

    invoke-static {v6}, Lmpop/revii/ai/util;->mpop([I)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-virtual {v2, v3}, Lmpop/revii/ai/connection;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 365
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0
.end method
