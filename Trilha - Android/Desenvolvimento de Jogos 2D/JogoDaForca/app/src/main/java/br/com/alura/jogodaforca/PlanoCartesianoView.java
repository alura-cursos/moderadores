package br.com.alura.jogodaforca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PlanoCartesianoView extends View {

    // armazena o valor do nosso display
    // caso o display seja menor na vertical a variavel guardara este valor
    // do contrário será guardado o valor da dimensào  da nossa tela na horizontal
    private int menorLadoDisplay;
    private int unidade;

    public int getMenorLadoDisplay() {
        return menorLadoDisplay;
    }
    public void setMenorLadoDisplay(int menorLadoDisplay) {
        this.menorLadoDisplay = menorLadoDisplay;
    }
    public int getUnidade() {
        return unidade;
    }
    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public PlanoCartesianoView(Context context) {
        super(context);
    }
    public PlanoCartesianoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getHeight() > getWidth())
            setMenorLadoDisplay(getWidth());
        else
            setMenorLadoDisplay(getHeight());
        setUnidade(getMenorLadoDisplay() / 10);
//        drawPlanoCartesiano(canvas);
    }

    public void drawPlanoCartesiano(Canvas canvas) {
        Path path = new Path();
        Paint paint = new Paint();
        int max = toPixel(10);
        for (int i = 0; i <= 10; i++) {
            // desenhando as linhas verticais
            path.moveTo(toPixel(i), 1);
            path.lineTo(toPixel(i), max);
            // desenhando as linhas horizontais
            path.moveTo(1, toPixel(i));
            path.lineTo(max, toPixel(i));
        }
        paint.setAntiAlias(true); // suavidade das linhas
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);

        canvas.drawPath(path, paint);
    }

    protected int toPixel(int vezes) {
        return vezes * getUnidade();
    }

}
