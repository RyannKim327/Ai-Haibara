.class Lmpop/revii/ai/AI$100000009;
.super Landroid/content/BroadcastReceiver;
.source "AI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000009"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;

.field private final val$chat:Lmpop/revii/ai/Markdown;

.field private final val$from:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/widget/TextView;Lmpop/revii/ai/Markdown;)V
    .locals 0

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000009;->this$0:Lmpop/revii/ai/AI;

    iput-object p2, p0, Lmpop/revii/ai/AI$100000009;->val$from:Landroid/widget/TextView;

    iput-object p3, p0, Lmpop/revii/ai/AI$100000009;->val$chat:Lmpop/revii/ai/Markdown;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000009;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000009;->this$0:Lmpop/revii/ai/AI;

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
    .line 476
    iget-object v0, p0, Lmpop/revii/ai/AI$100000009;->this$0:Lmpop/revii/ai/AI;

    iget-object v0, v0, Lmpop/revii/ai/AI;->context:Landroid/content/Context;

    const-string v1, "TEXTSIZE"

    invoke-static {v0, v1}, Lmpop/revii/ai/util;->key(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0xa

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 477
    iget-object v1, p0, Lmpop/revii/ai/AI$100000009;->val$from:Landroid/widget/TextView;

    int-to-float v2, v0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextSize(F)V

    .line 478
    iget-object v1, p0, Lmpop/revii/ai/AI$100000009;->val$chat:Lmpop/revii/ai/Markdown;

    div-int/lit8 v2, v0, 0x2

    add-int/2addr v0, v2

    int-to-float v0, v0

    invoke-virtual {v1, v0}, Lmpop/revii/ai/Markdown;->setTextSize(F)V

    return-void
.end method
