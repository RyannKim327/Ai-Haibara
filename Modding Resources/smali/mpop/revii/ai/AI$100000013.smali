.class Lmpop/revii/ai/AI$100000013;
.super Landroid/webkit/WebView;
.source "AI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmpop/revii/ai/AI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x20
    name = "100000013"
.end annotation


# instance fields
.field private final this$0:Lmpop/revii/ai/AI;


# direct methods
.method constructor <init>(Lmpop/revii/ai/AI;Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0, p2}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    iput-object p1, p0, Lmpop/revii/ai/AI$100000013;->this$0:Lmpop/revii/ai/AI;

    return-void
.end method

.method static access$0(Lmpop/revii/ai/AI$100000013;)Lmpop/revii/ai/AI;
    .locals 1

    iget-object v0, p0, Lmpop/revii/ai/AI$100000013;->this$0:Lmpop/revii/ai/AI;

    return-object v0
.end method


# virtual methods
.method public onCheckIsTextEditor()Z
    .locals 1
    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 662
    const/4 v0, 0x1

    return v0
.end method
