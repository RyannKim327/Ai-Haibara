.class Lmpop/revii/ai/AI$100000003;
.super Ljava/lang/Object;
.source "AI.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000003"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000003;->this$0:Lmpop/revii/ai/AI;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000003;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000003;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 1
    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 290
    const/4 v0, 0x1

    return v0
.end method
