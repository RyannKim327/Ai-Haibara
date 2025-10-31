.class Lmpop/revii/ai/AI$100000008;
.super Landroid/content/BroadcastReceiver;
.source "AI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000008"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;)V
    .locals 0

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000008;->this$0:Lmpop/revii/ai/AI;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000008;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000008;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
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
    .line 388
    iget-object v0, p0, Lmpop/revii/ai/AI$100000008;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->sp:Landroid/content/SharedPreferences;

    const-string v1, "TEXT_TO_SPEECH"

    invoke-static {p1, v1}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 389
    iget-object v0, p0, Lmpop/revii/ai/AI$100000008;->this$0:Lmpop/revii/ai/AI;

    invoke-virtual {v0}, Lmpop/revii/ai/AI;->speak()V

    :cond_0
    return-void
.end method
