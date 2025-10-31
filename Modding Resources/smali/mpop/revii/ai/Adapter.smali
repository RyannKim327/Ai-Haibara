.class public Lmpop/revii/ai/Adapter;
.super Landroid/widget/ArrayAdapter;
.source "Adapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field ctx:Landroid/content/Context;

.field lang:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    const-string v0, "layout_list"

    const-string v1, "layout"

    invoke-static {p1, v0, v1}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-direct {p0, p1, v0, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 23
    iput-object p1, p0, Lmpop/revii/ai/Adapter;->ctx:Landroid/content/Context;

    .line 24
    iput-object p3, p0, Lmpop/revii/ai/Adapter;->list:Ljava/util/ArrayList;

    .line 25
    iput-object p2, p0, Lmpop/revii/ai/Adapter;->lang:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method public fetchItem(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    invoke-virtual {p0, p1}, Lmpop/revii/ai/Adapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .annotation runtime Ljava/lang/Override;
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lmpop/revii/ai/Adapter;->ctx:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iget-object v1, p0, Lmpop/revii/ai/Adapter;->ctx:Landroid/content/Context;

    const-string v2, "layout_list"

    const-string v3, "layout"

    invoke-static {v1, v2, v3}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    .line 31
    iget-object v0, p0, Lmpop/revii/ai/Adapter;->ctx:Landroid/content/Context;

    const-string v1, "baseLayout"

    const-string v2, "id"

    invoke-static {v0, v1, v2}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 32
    iget-object v1, p0, Lmpop/revii/ai/Adapter;->ctx:Landroid/content/Context;

    const-string v2, "number"

    const-string v3, "id"

    invoke-static {v1, v2, v3}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v5, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 33
    iget-object v2, p0, Lmpop/revii/ai/Adapter;->ctx:Landroid/content/Context;

    const-string v3, "code"

    const-string v4, "id"

    invoke-static {v2, v3, v4}, Lmpop/revii/ai/util;->setResources(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v5, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 34
    const/high16 v3, 0x41000000    # 8.0f

    .line 35
    new-instance v6, Landroid/graphics/drawable/ShapeDrawable;

    new-instance v7, Landroid/graphics/drawable/shapes/RoundRectShape;

    const/16 v4, 0x8

    new-array v8, v4, [F

    const/4 v4, 0x0

    aput v3, v8, v4

    const/4 v4, 0x1

    aput v3, v8, v4

    const/4 v4, 0x2

    aput v3, v8, v4

    const/4 v4, 0x3

    aput v3, v8, v4

    const/4 v4, 0x4

    aput v3, v8, v4

    const/4 v4, 0x5

    aput v3, v8, v4

    const/4 v4, 0x6

    aput v3, v8, v4

    const/4 v4, 0x7

    aput v3, v8, v4

    const/4 v3, 0x0

    check-cast v3, Landroid/graphics/RectF;

    const/4 v4, 0x0

    check-cast v4, [F

    invoke-direct {v7, v8, v3, v4}, Landroid/graphics/drawable/shapes/RoundRectShape;-><init>([FLandroid/graphics/RectF;[F)V

    invoke-direct {v6, v7}, Landroid/graphics/drawable/ShapeDrawable;-><init>(Landroid/graphics/drawable/shapes/Shape;)V

    .line 40
    rem-int/lit8 v3, p1, 0x2

    if-nez v3, :cond_0

    .line 41
    invoke-virtual {v6}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v3

    const v4, -0xbbbbbc

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 42
    const/4 v3, -0x1

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 43
    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 50
    :goto_0
    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 51
    const-string v3, "[%d]: %s Code"

    const/4 v0, 0x2

    new-array v4, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    add-int/lit8 v6, p1, 0x1

    new-instance v7, Ljava/lang/Integer;

    invoke-direct {v7, v6}, Ljava/lang/Integer;-><init>(I)V

    aput-object v7, v4, v0

    const/4 v6, 0x1

    iget-object v0, p0, Lmpop/revii/ai/Adapter;->lang:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aput-object v0, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 52
    iget-object v0, p0, Lmpop/revii/ai/Adapter;->list:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 53
    sget-object v0, Landroid/graphics/Typeface;->SERIF:Landroid/graphics/Typeface;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 54
    sget-object v0, Landroid/graphics/Typeface;->SERIF:Landroid/graphics/Typeface;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 56
    return-object v5

    .line 45
    :cond_0
    invoke-virtual {v6}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v3

    const v4, -0x333334

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 46
    const/high16 v3, -0x1000000

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 47
    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method
