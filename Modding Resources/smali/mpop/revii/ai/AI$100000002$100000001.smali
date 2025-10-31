.class Lmpop/revii/ai/AI$100000002$100000001;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI$100000002;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000001"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI$100000002;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI$100000002;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000002$100000001;->this$0:Lmpop/revii/ai/AI$100000002;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000002$100000001;)Lmpop/revii/ai/AI$100000002;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000002$100000001;->this$0:Lmpop/revii/ai/AI$100000002;

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
    .line 255
    iget-object v0, p0, Lmpop/revii/ai/AI$100000002$100000001;->this$0:Lmpop/revii/ai/AI$100000002;

    invoke-static {v0}, Lmpop/revii/ai/AI$100000002;->access$0(Lmpop/revii/ai/AI$100000002;)Lmpop/revii/ai/AI;

    move-result-object v0

    iget-object v0, v0, Lmpop/revii/ai/AI;->sc:Landroid/widget/ScrollView;

    const/16 v1, 0x82

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->fullScroll(I)Z

    return-void
.end method
