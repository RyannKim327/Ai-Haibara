.class Lmpop/revii/ai/AI$100000005$100000004;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI$100000005;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000004"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI$100000005;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI$100000005;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000005$100000004;->this$0:Lmpop/revii/ai/AI$100000005;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000005$100000004;)Lmpop/revii/ai/AI$100000005;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000005$100000004;->this$0:Lmpop/revii/ai/AI$100000005;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 346
    iget-object v0, p0, Lmpop/revii/ai/AI$100000005$100000004;->this$0:Lmpop/revii/ai/AI$100000005;

    invoke-static {v0}, Lmpop/revii/ai/AI$100000005;->access$0(Lmpop/revii/ai/AI$100000005;)Lmpop/revii/ai/AI;

    move-result-object v0

    iget-object v0, v0, Lmpop/revii/ai/AI;->sc:Landroid/widget/ScrollView;

    const/16 v1, 0x82

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->fullScroll(I)Z

    return-void
.end method
